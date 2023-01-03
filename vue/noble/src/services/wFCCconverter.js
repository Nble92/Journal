import axios from "axios";

export default{


 converter(){

const regex = /<td>([^<]+)<\/td>\s*<td>\s*Required[^\d]*([\d]+)\s*<\/td>\s*<td>[\^d]*\s*([\d]+)/;

// Alternative syntax using RegExp constructor
// const regex = new RegExp('class="table">([\\s\\S]*?)<\\/table>', '')

const str = axios.get('https://cors-anywhere.com/http://watchfreecodecamp.com/Scanner/IndexResult?id=Noble92',
{
headers: {
    'X-Requested-With': 'XMLHttpRequest'
  }
})
.then(response => {
  console.log(response.data);
})
.catch(error => {
  console.log(error);
});

let m;


var courses = []


const flags = regex.global ? regex.flags : regex.flags + "g";

let regEx = new RegExp(regex, flags);
let i = 0;
while ((m = regEx.exec(str, flags)) !== null) {
    // The result can be accessed through the `m`-variable.
    let course = {
        name: "",
        completed: 0,
        total: 0,
        percent: 0
    };
    m.forEach((match, groupIndex) => {

        if (groupIndex == 1) {

            course.name = match.trim()
            console.log(match);
        }
        else if (groupIndex == 2) {

            course.completed = match
        }
        else if (groupIndex == 3) {

            course.total = match
        }

        course.percent = (course.completed / course.total) * 100

        // console.log(`Found match, group ${groupIndex}: ${match}`);


    });

    courses.push(course)
    console.log(i);
    i++;


}
// console.log(courses.length)
console.log('done')
console.log(courses)
}
}
