define([
  'hbs!templates/addref',
  'bjq',
  'controllers/listref'
], function(tplList, bjq, list) {

  // Renders the login form inside element.
  function render(element) {
//    Handlebars.registerPartial('reference', tplRef);
    element.html(tplList());
    bindEvents(element);
  }

  // Add form events.
  function bindEvents(element) {
    var submitClick = element.find('button.submit').asEventStream('click').doAction('.preventDefault');

    // Form submitted.
    submitClick.onValue(function() {
      var data = getFormValues(element.find('form'));
      console.log(data);
      list.add(data);

    });
  }

  // Gets form values from the add form.
  function getFormValues(form) {
    var fields = form.find('[data-type="field"]'),
        meta = form.find('[data-type="meta"]'),
        data = {'fields' : {}};

    fields.each(function(i, el) {
      var el = $(el);
      data.fields[el.prop('name')] = el.val();
    })

    meta.each(function(i, el) {
      var el = $(el);
      data[el.prop('name')] = el.val();
    })

    return data;
  }


  return {
    init: render
  }

});