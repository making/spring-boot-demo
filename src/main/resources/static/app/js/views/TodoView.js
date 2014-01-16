/*global define*/
define(function (require) {
    'use strict';

    var Backbone = require('backbone');
    var Handlebars = require('handlebars');
    var _ = require('underscore');
    var todos = require('text!app/js/templates/todos.hbs');

    return Backbone.View.extend({
        tagName: 'li',
        template: Handlebars.compile(todos),
        initialize: function () {
            this.listenTo(this.model, 'change', this.render);
        },
        render: function () {
            this.$el.html(template(this.model.toJSON()));
            return this;
        }
    });
});