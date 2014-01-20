/*global define*/
define(function (require) {
    'use strict';

    var Backbone = require('backbone');
    var _ = require('underscore');

    var Todo = require('app/js/models/Todo');
    var Todos = require('app/js/collections/Todos');
    var TodoView = require('app/js/views/TodoView');

    return Backbone.View.extend({
        events: {
            'keypress #new-todo': 'createOnEnter',
            'click #toggle-all': 'toggleAll',
            'click #clear-finished': 'clearFinished'
        },
        initialize: function () {
            this.$input = this.$('#new-todo');
            this.$todoList = this.$('#todo-list');
            this.$toggleAll = this.$('#toggle-all');
            this.$clearFinished = this.$('#clear-finished');

            this.todos = new Todos();
            this.listenTo(this.todos, 'sync', this.render);
            this.listenTo(this.todos, 'sort', function() {
                console.log(arguments);
            });
            this.todos.fetch();
        },
        render: function () {
            this.$todoList.empty();
            // this.todos.sort();
            this.todos.each(_.bind(function (todo) {
                var todoView = new TodoView({
                    model: todo
                });
                this.$todoList.append(todoView.render().el);
            }, this));

            this.$toggleAll.prop('checked', this.todos.isAllFinished());

            if (this.todos.remaining().length) {
                this.$clearFinished.show();
            } else {
                this.$clearFinished.hide();
            }
            return this;
        },
        createOnEnter: function (e) {
            if (e.keyCode != 13) return;
            var todoTitle = this.$input.val();
            if (!todoTitle) return;
            var newTodo = new Todo({
                todoTitle: todoTitle
            });
            this.todos.create(newTodo);
            this.$input.val('');
        },
        toggleAll: function () {
            var finished = this.$toggleAll.prop('checked');
            this.todos.toggleAll(finished);
        },
        clearFinished: function () {
            this.todos.destroyRemaining();
            this.render();
        }
    });
})
;