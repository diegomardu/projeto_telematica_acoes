let x = document.querySelectorAll(".table-row");

let filterList = document.querySelectorAll(".search-box")

for ( let j = 0 ; j<filterList.length;j++){
    getData(filterList[j],j);
}

function getData(filter,number){
    filter.addEventListener("input",function(){
        let filterEmpresa =  filter.value;
        let RegEmpresa = new RegExp(filterEmpresa);

           for (let c = 0 ; c < x.length; c++ ){
               let row = x[c].querySelectorAll(".text-center");
               if (!row[number].textContent.match(RegEmpresa)){
                   x[c].classList.add("display-oppacity")
                   setTimeout(function (){
                           x[c].classList.add("display-none")
                       },
                       1000)
               }
               if(row[1].textContent.match("") || row[number].textContent.match(RegEmpresa)){
                   x[c].classList.remove("display-oppacity")
                   x[c].classList.remove("display-none")
               }
           }
    })
}

let searchBox = document.querySelector(".search-box__container")

searchBox.addEventListener("click",function (){
    setTimeout(function (){
        let contentBox = document.querySelector(".content-box");
        contentBox.classList.add("content-box-animation")
        contentBox.classList.remove("content-box__animation-reverse")
    },1000);
})

searchBox.addEventListener("dblclick",function (){
    setTimeout(function (){
        let contentBox = document.querySelector(".content-box");
        contentBox.classList.remove("content-box-animation")
        contentBox.classList.add("content-box__animation-reverse")
    },2000);
})