define([
  'hbs!templates/edit'
], function(tplEdit) {

  function render(element, id) {
    var data = getData(id);

    $('#add-reference').fadeOut(300, function() {
      data.done(function(data) {
        element.html(tplEdit(data));
        bindEvents(element);
        element.fadeIn(300);
      });
    })
  }

  function bindEvents(element) {
    element.find('.cancel').on('click', function(e) {
      e.preventDefault();
      element.fadeOut(300, function() {
        $('#add-reference').fadeIn(300);
      })
    });
  }

  function getData(id) {
    var deferred = $.Deferred();

    // Loads the references from server.
    var request = Bacon.once({
      type: 'get',
      url: '/listaaviite.do?id=' + id,
    }).ajax();

    // Success callback.
    request.onValue(function(response) {
      console.log(response)
      deferred.resolve(response);
    });

    // Error callback.
    request.onError(function(err) {
      deferred.reject(err);
      console.log(err);
    });

    return deferred.promise();
  }

  return {
    init: render
  }

});