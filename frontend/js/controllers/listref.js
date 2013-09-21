define([
  'hbars!templates/listref',
  'dev/dummy-references'
], function(template, data) {
  var element = null;

  // Renders the login form inside element.
  function render(elem) {
    element = elem;
    element.html(template(data));
    //bindEvents(element);
  }

  function append(data) {
    element.find('ul').append(data);
  }


  return {
    init: render,
    add: append
  }

});