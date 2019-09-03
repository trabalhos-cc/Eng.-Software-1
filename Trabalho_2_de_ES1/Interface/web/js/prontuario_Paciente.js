/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let btn = document.querySelector('#btn');
let list = docment.querySelector('#list');

btn.addEventListener('click', function(){
    fetch('https://regres.in//api/users?page=2')
            .then(function(response){
                return response.json();
    })
            .then(function(response){
                console.log(response);
    })
});