/*global require*/
'use strict';

// Require.js allows us to configure shortcut alias
require.config({
    // The shim config allows us to configure dependencies for
    // scripts that do not call define() to register a module
    baseUrl: '../..',
    shim: {
        underscore: {
            exports: '_'
        },
        backbone: {
            deps: [
                'underscore',
                'jquery'
            ],
            exports: 'Backbone'
        },
        handlebars: {
            exports: 'Handlebars'
        }
    },
    paths: {
        jquery: 'vendor/jquery/jquery',
        underscore: 'vendor/lodash/dist/lodash',
        backbone: 'vendor/backbone/backbone',
        'backbone.stickit': 'vendor/backbone.stickit/backbone.stickit',
        'backbone.validation': 'vendor/backbone.validation/src/backbone-validation-amd',
        handlebars: 'vendor/handlebars/handlebars',
        bootstrap: 'vendor/bootstrap/dist/js/bootstrap',
        text: 'vendor/requirejs-text/text'
    }
});

define(function (require) {
    var $ = require('jquery');

    $(document).ready(function () {
        alert('Good!');
    });
});