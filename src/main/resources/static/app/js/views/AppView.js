/*global define*/
define(function (require) {
    'use strict';

    var Backbone = require('backbone');
    var _ = require('underscore');

    var Todos = require('app/js/collections/Todos');
    var TodoView = require('app/js/views/TodoView');

    return Backbone.View.extend({
        initialize: function () {
            this.input = this.$('#new-todo');
            this.main = this.$('#main');
            this.todoList = this.main.find('#todo-list');

            this.todos = new Todos();
            this.listenTo(this.todos, 'all', this.render);
            this.todos.fetch();
        },
        render: function () {
            this.todoList.empty();
            this.todos.forEach(_.bind(function (todo) {
                var todoView = new TodoView({
                    model: todo
                });
                this.todoList.append(todoView.render().el);
            }, this));
            return this;
        }
    });
});