require({

  catchError: true,

  baseUrl: './js',

  hbs : {
    templateExtension : 'hbars',
    disableI18n : true
  },

  paths: {
    jquery: 'lib/jquery-1.10.2.min',
    templates: '../templates',
    Handlebars: 'lib/handlebars',
    hbs: 'lib/hbs',
    underscore : 'lib/hbs/underscore',
    i18nprecompile : 'lib/hbs/i18nprecompile',
    json2 : 'lib/hbs/json2',
    bacon: 'lib/bacon',
    bjq: 'lib/bacon-bjq',
    lodash: 'lib/lodash',
    moment: 'lib/moment',
  },
  shim: {
    Handlebars: { exports: 'Handlebars' },
    bacon: { exports: 'Bacon' },
    bjq: { deps: ['jquery', 'bacon'] },
    jquery: { exports: '$' },
    lodash: { exports: '_' },
    error: { deps: ['jquery']}
  }
})

require([
  'jquery',
  'bacon',
  'lodash',
  'controllers/listref',
  'controllers/addref',
  'controllers/download'
], function($, bacon, _, list, add, download) {

  list.init($('#list-references'));
  add.init($('#add-reference'));
  download.init($('#download-references'));
})