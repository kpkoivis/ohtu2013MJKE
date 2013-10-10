define([
  'hbs!templates/download'
], function(tplDownload) {
  var element = null;

  // Renders the login form inside element.
  function render(elem) {
    element = elem;
    element.html(tplDownload());
  }

  return {
    init: render,
  }

});