$('#calendar').fullCalendar({
    header: {
        left: 'prev,next today',
        center: 'title',
        right: 'month,basicWeek,basicDay',
    },
    navLinks: true, // can click day/week names to navigate views
    editable: true,
    eventLimit: true,
    events: {
        url: '/getPostsDates.json',
        type: 'GET',
        error: function(){
            alert("There was an error getting the event dates");
        },
        color: '#37474f',
        textColor: 'white'
    }
});