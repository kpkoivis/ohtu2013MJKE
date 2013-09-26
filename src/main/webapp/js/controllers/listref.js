define([
  'hbs!templates/listref',
  'dev/dummy-references',
  'hbs!templates/reference'
], function(tplList, data, tplReference) {
  var element = null;

  // Renders the login form inside element.
  function render(elem) {
    element = elem;

    // Loads the references from server.
    var request = Bacon.once({
      type: 'get',
      url: '/vhj/listaaviitteet.do'
    }).ajax();

    // Success callback.
    request.onValue(function(response) {
      element.html(tplList(response));
    });

    // Error callback.
    request.onError(function(err) {
      console.log(err);
    });


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