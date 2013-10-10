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
      url: '/listaaviitteet.do'
    }).ajax();

    // Success callback.
    request.onValue(function(response) {
      element.html(tplList(response));
      bindEvents(element.find('.reference'));
    });

    // Error callback.
    request.onError(function(err) {
      console.log(err);
    });

  }

  function bindEvents(elements) {
    elements.find('.edit').not('.processed').on('click', function(e) {
      e.preventDefault();
      var $this = $(this),
          $ref = $this.parents('li');

      $this.addClass('processed');
      console.log('fuu');
    })

     elements.find('.delete').not('.processed').on('click', function(e) {
       e.preventDefault();
       var $this = $(this),
           $ref = $this.parents('li');

       $this.addClass('processed');

      // Loads the references from server.
      var request = Bacon.once({
        contentType: 'application/json',
        dataType: 'json',
        type: 'post',
        url: '/poistaviite.do',
        data: JSON.stringify({id : $ref.data('id') })
      }).ajax();

      // Success callback.
      request.onValue(function(response) {
        $ref.fadeOut(300, function() {
          $(this).remove();
        });
      });

      // Error callback.
      request.onError(function(err) {
        console.log(err);
      });

       console.log($ref.data('id'))


    })

  }

  function append(data) {
    element.find('ul').append(tplReference(data));
    bindEvents(element.find('.reference'));
  }

  function remove(id) {
    var ref = element.find('[data-referenceId="' + id + '"]');
    ref.remove();
  }

  return {
    init: render,
    add: append
  }

});