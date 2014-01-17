/*global define*/
define(function (require) {
    'use strict';

    var Backbone = require('backbone');

    return Backbone.Collection.extend({
        url: 'http:/localhost:8080/api/todos',
        comparator: function (todo) {
            return todo.get('createdDate');
        }
    });
});