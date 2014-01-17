/*global define*/
define(function (require) {
    'use strict';

    var Backbone = require('backbone');

    return Backbone.Model.extend({

        idAttribute: 'todoId',
        urlRoot: 'http:/localhost:8080/api/todos',

        defaults: {
            todoTitle: '',
            finished: false
        },

        // Toggle the `completed` state of this todo item.
        toggle: function () {
            this.save({
                finished: !this.get('finished')
            });
        }
    });
});