angular
		.module('parcelConfig')
		.component(
				'parcelSize',
				{
					transclude : true,
					template : '<div class="w3-panel w3-card-2">'
							+ '<div class="w3-container w3-teal">'
							+ '<h2>Paketgröße</h2>'
							+ '</div>'
							+ '<form class="w3-container">'
							+

							'<div class="w3-row">'
							+ '<label>Länge</label>'
							+ '<input class="w3-input" type="text" ng-model="$ctrl.parcel.length">'
							+ '</div>'
							+

							'<div class="w3-row">'
							+ '<label>Breite</label>'
							+ '<input class="w3-input" type="text" ng-model="$ctrl.parcel.width">'
							+ '</div>'
							+

							'<div class="w3-row">'
							+ '<label>Höhe</label>'
							+ '<input class="w3-input" type="text" ng-model="$ctrl.parcel.height">'
							+ '</div>'
							+

							'<div class="w3-row">'
							+ '<div class="w3-cell">'
							+ '<button class="w3-button w3-teal" ng-click="$ctrl.calculateSize()" >Größe berechnen</button>'
							+ '</div>'
							+ '<div class="w3-cell">'
							+ '<p>Paketgröße: {{$root.parcelsize.size}} </p>'
							+ '</div>' +

							'</form>' + '</div>',

					controller : function ParcelSizeController($rootScope,
							$http) {
						this.parcel = { // Attribut mit enthaltenen
										// Attributen/Methoden
							size : '', // Unterattribute
							length : 0, // Wert wird eingetragen über
										// databinding von agularjs via ng-model
							width : 0,
							height : 0
						};
						this.calculateSize = function() { // Länge, Breite,
															// Höhe muss man
															// nicht mitgeben,
															// weil controller
															// sie schon kennt
							$http.post('http://www.allgaeu-parcel-service.de:1100/rest/size',
									this.parcel).then(
									function success(response) {
										$rootScope.parcelsize = response.data;// von localhost:8081 zu parcelsizecomponent umbenannt
										//console.log(response.data); Ausgabe auf der Konsole
									// console.log($rootScope.parcelsize);
									}, function failure(response) {
										$rootScope.parcelsize = null;
										alert("Etwas hat nicht funktioniert.");
									}); // nehmen wir im body unserer Anfrage
										// mit

						}
					}
				});
