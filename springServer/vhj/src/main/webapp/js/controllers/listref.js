define([
  'hbs!templates/listref',
  'dev/dummy-references',
  'hbs!templates/reference'
], function(tplList, data, tplReference) {
  var element = null;

  // Renders the login form inside element.
  function render(elem) {
    element = elem;

    // TODO: Load the data from server.
    // Get /listaaviitteet
    console.log(data);
    element.html(tplList(data));

    // TODO: Add logic for editing the references.
  }

  function append(data) {
    element.find('ul').append(tplReference(data));
  }

  return {
    init: render,
    add: append
  }

});