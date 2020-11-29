let startDate="2020-05-26";
let gradDate="2020-11-12";


/*
function dateToString(date){
    var parts=date.split("-",3);
    var dateString = new Date(parts[0], parts[1] - 1, parts[2]);
    return dateString;
}*/
/*

function daysBetween(date1, date2) {

    let count=0;
    while(date1<date2){
        count+=1;
        date1.setDate(date1+1);
    }
    return count;
}*//*
function percentComplete (date1, date2) {
    let result;
    result=Number(
        daysBetween(new Date(), startDate)
        /
        daysBetween(gradDate, startDate)
    );
    return result;
}*/

console.log(typeof(startDate));