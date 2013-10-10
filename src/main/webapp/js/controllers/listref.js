define([
  'hbs!templates/listref',
  'hbs!templates/reference',
  'controllers/edit'
], function(tplList, tplReference, edit) {
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

      edit.init($('#edit-reference'), $ref.data('id'));
    })

     elements.find('.delete').not('.processed').on('click', function(e) {
       e.preventDefault();
       var $this = $(this),
           $ref = $this.parents('li');

       $this.addClass('processed');

        if(confirm('Haluatko varmasti poistaa viitteen?')) {
          // Deletes the references from server.
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
        }

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