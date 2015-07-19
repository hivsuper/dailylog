(function() {
	if (!window.basePath) {
		window.basePath = document.getElementsByTagName('script')[document
				.getElementsByTagName('script').length - 1].src.replace(
						new RegExp('/swagger/tools\.js*'), '');
	}
})();