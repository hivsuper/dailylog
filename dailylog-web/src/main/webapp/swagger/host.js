(function() {
	if (!window.basePath) {
		var path = document.getElementsByTagName('script')[document.getElementsByTagName('script').length - 1].src;
		path = path.split('?')[0];
		window.basePath = path.replace(new RegExp('/swagger/host\.js'), '');
	}
})();