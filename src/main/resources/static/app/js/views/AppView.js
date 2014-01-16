/*global define*/
define(function (require) {
    'use strict';

    var Backbone = require('backbone');
    var _ = require('underscore');

    var Todos = require('app/js/collections/Todos');

    return Backbone.View.extend({
        initialize: function () {
            this.input = this.$('#new-todo');
            this.main = this.$('#main');

            this.todos = new Todos();
            this.listenTo(this.todos, 'all', this.render);
            this.todos.fetch();
        },
        render: function () {
            return this;
        }
    });
});