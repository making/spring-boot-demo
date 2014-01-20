define(function (require) {
    'use strict';

    var Backbone = require('backbone');
    var Handlebars = require('handlebars');
    var _ = require('underscore');
    var todo = require('text!app/js/templates/todo.hbs');

    return Backbone.View.extend({
        tagName: 'li',
        template: Handlebars.compile(todo),
        events: {
            'click .destroy': 'destroy',
            'click .toggle': 'toggle',
            'dblclick .view': 'edit',
            'keypress .edit': 'updateOnEnter',
            'blur .edit': 'close'
        },
        initialize: function () {
            this.listenTo(this.model, 'change', this.render);
            this.listenTo(this.model, 'destroy', this.remove);
        },
        render: function () {
            this.$el.html(this.template(this.model.toJSON()));
            this.$input = this.$('.edit');
            this.$el.toggleClass('finished', this.model.get('finished'));
            return this;
        },
        destroy: function () {
            this.model.destroy();
        },
        toggle: function () {
            this.model.toggle();
        },
        edit: function () {
            this.$el.addClass('editing');
            this.$input.focus();
        },
        updateOnEnter: function (e) {
            if (e.keyCode != 13) return;
            this.close();
        },
        close: function () {
            var newTitle = this.$input.val();
            if (newTitle) {
                this.model.save({todoTitle: newTitle});
            }
            this.$el.removeClass('editing');
        }
    });
});