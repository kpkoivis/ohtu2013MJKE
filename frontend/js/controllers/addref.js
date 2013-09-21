define([
  'hbars!templates/addref',
  'bjq',
  'controllers/listref'
], function(template, bjq, list) {

  // Renders the login form inside element.
  function render(element) {
    element.html(template());
    bindEvents(element);
  }

  // Add form events.
  function bindEvents(element) {
    var submitClick = element.find('button.submit').asEventStream('click').doAction('.preventDefault');

    // Form submitted.
    submitClick.onValue(function() {
      var data = getFormValues(element.find('form'));

      addNewReference(data);

    });
  }

  // Gets form values from the add form.
  function getFormValues(form) {
    var inputs = form.find('input'),
        selects = form.find('select'),
        data = {};

    inputs.each(function(i, el) {
      var el = $(el);
      data[el.prop('name')] = el.val();
    })

    selects.each(function(i, el) {
      var el = $(el);
      data[el.prop('name')] = el.val();
    })

    return data;
  }

  // Submits the data to server updates view.
  function addNewReference(data) {
    list.add('<li>FUUU</li>');
    // TODO: A cross refenrence to lis for adding ad new

  }


  return {
    init: render
  }

});