(function($) {
    var request = $.ajax({'url': '/calendars.json'});
    request.done(function (cohorts) {
        var html = '';
        cohorts.forEach(function(cohort) {
            html += '<div>';
            html += '<h1>' + cohort.title + '</h1>';
            html += '<h1>' + cohort.startDate + '</h1>'
            html += '</div>';

            /*
            'string','Task ID'
            'string','Task Name'
            'string', 'Resource'
            'date','Start Date'
            'date','End Date'
            'number','Duration'
            'number','Percent Complete
            'string','Dependencies'


             */

        });
        $('#cohorts').html(html);
    });
})(jQuery);