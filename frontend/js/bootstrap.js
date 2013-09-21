require({

  catchError: true,

  baseUrl: './js',

  paths: {
    jquery: 'lib/jquery-1.10.2.min',
    templates: '../templates',
    Handlebars: 'lib/handlebars',
    hbars: 'lib/hbars',
    text: 'lib/text',
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
  },
  hbars: {
    extension: '.hbars'
  }
})

require([
  'jquery',
  'bacon',
  'lodash',
  'controllers/listref',
  'controllers/addref'
], function($, bacon, _, list, add) {

  list.init($('#list-references'));
  add.init($('#add-reference'));
})