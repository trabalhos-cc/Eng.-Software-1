/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function show(id) {
    var div = document.getElementById(id);
    if (div.style.display === "none"){
        div.style.display = "block";
    } else {
        div.style.display = "none";
    }
}

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah')
                    .attr('src', e.target.result)
                    .width(150)
                    .height(200);
        };

        reader.readAsDataURL(input.files[0]);
    }
}