jQuery(document).ready(function(){
	jQuery("#add-event").submit(function(){
		alert("Submitted");
		var values = {};
		$.each($('#add-event').serializeArray(), function(i, field) {
			values[field.name] = field.value;
		});
		console.log(
			values
		);
	});
});

(function () {
	'use strict';
	// ------------------------------------------------------- //
	// Calendar
	// ------------------------------------------------------ //
	jQuery(function() {
		// page is ready
		jQuery('#calendar').fullCalendar({
			themeSystem: 'bootstrap4',
			// emphasizes business hours
			businessHours: false,
			defaultView: 'month',
			// event dragging & resizing
			editable: true,
			// header
			header: {
				left: 'title',
				center: 'month,agendaWeek,agendaDay',
				right: 'today prev,next'
			},
			events: [
			
			{
				title: 'Projet JEE',
				description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
				start: '2021-02-22',
				end: '2021-02-22',
				className: 'fc-bg-default',
				icon : "rocket"
				
			},
			{
				title: 'Achitecture des ordinateurs',
				description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
				start: '2021-02-22',
				end: '2021-02-22',
				className: 'fc-bg-default',
				icon : "laptop"
				
			},
			{
				title: 'TCP/IP',
				description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
				start: '2021-02-09',
				end: '2021-02-09',
				className: 'fc-bg-default',
				icon : "network-wired"
				
			},
			{
				title: 'Technologie Web',
				description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
				start: '2021-02-11',
				end: '2021-02-11',
				className: 'fc-bg-blue',
				icon : "file-code"
			},
			{
				title: 'Compilation',
				description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
				start: '2021-02-17',
				end: '2021-02-17',
				className: 'fc-bg-default',
				icon : "laptop-code"
			},
			{
				title: 'Génie Logiciel',
				description: 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras eu pellentesque nibh. In nisl nulla, convallis ac nulla eget, pellentesque pellentesque magna.',
				start: '2021-02-15',
				end: '2021-02-15',
				className: 'fc-bg-blue',
				icon : "map-signs"
				
			}
			],
			dayClick: function() {
				jQuery('#modal-view-event-add').modal();
			},
			eventClick: function(event, jsEvent, view) {
				jQuery('.event-icon').html("<i class='fas fa-"+event.icon+"'></i>");
				jQuery('.event-title').html(event.title);
				jQuery('.event-body').html(event.description);
				jQuery('.eventUrl').attr('href',event.url);
				jQuery('#modal-view-event').modal();
			},
		})
});

})(jQuery);