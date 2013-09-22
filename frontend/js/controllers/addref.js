define([
  'hbars!templates/addref',
  'hbars!templates/reference',
  'bjq',
  'controllers/listref'
], function(tplList, tplRef, bjq, list) {

  // Renders the login form inside element.
  function render(element) {
    Handlebars.registerPartial('reference', tplRef);
    console.log(Handlebars.partials);
    console.log(Handlebars.templates);
    element.html(tplList());
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
    list.add(tplRef(data));

  }


  return {
    init: render
  }

});