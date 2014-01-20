define(function (require) {
    'use strict';

    var Backbone = require('backbone');
    var Todo = require('app/js/models/Todo');

    return Backbone.Collection.extend({
        model: Todo,
        url: 'http://localhost:8080/api/todos',
        comparator: function (a, b) {
            var aIsFinished = a.get('finished');
            var bIsFinished = b.get('finished');
            if ((aIsFinished && bIsFinished) || (!aIsFinished && !bIsFinished)) {
                return (a.get('createdAt') > b.get('createdAt')) ? 1 : -1;
            } else {
                return (aIsFinished > bIsFinished) ? 1 : -1;
            }
        },
        toggleAll: function (finished) {
            this.each(function (todo) {
                if (todo.get('finished') === finished) return;
                // {silent:true}しないと、AppView.sortが発火されて、eachの順が毎回変わってしまう
                todo.save({finished: finished}, {silent: true});
            });
            this.sort();
        },
        isAllFinished: function () {
            if (!this.size()) {
                return false;
            }
            return _.reduce(this.pluck('finished'), function (a, b) {
                return a && b;
            });
        },
        remaining: function () {
            return this.where({finished: true});
        },
        destroyRemaining: function () {
            _.each(this.remaining(), function (todo) {
                todo.destroy();
            });
        }
    });
});