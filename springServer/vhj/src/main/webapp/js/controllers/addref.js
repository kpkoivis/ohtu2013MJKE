define([
  'hbs!templates/addref',
  'bjq',
  'controllers/listref'
], function(tplList, bjq, list) {

  // Renders the login form inside element.
  function render(element) {
    element.html(tplList());
    bindEvents(element);
  }

  // Add form events.
  function bindEvents(element) {
    var submitClick = element.find('button.submit').asEventStream('click').doAction('.preventDefault');

    // TODO: Don't allow form submission without all fields filled.

    // Form submitted.
    submitClick.onValue(function() {
      var data = getFormValues(element.find('form'));

      // Ajax post request for adding data.
      var request = Bacon.once({
        contentType: 'application/json',
        dataType: 'json',
        type: 'post',
        data: JSON.stringify(data.fields),
        url: '/vhj/lisaaviite.do'
      }).ajax();

      request.onValue(function(response) {
        list.add(data.fields);
      });
      request.onError(function(err) {
        console.log(err);
      });

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