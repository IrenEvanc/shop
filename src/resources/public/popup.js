const popupLinks = document.querySelectorAll('.popup-link'); //получаем все объекты из popup-link
const body = document.querySelector('body'); //в body получаем сам тэг
const lockPadding = document.querySelectorAll(".lock-padding"); //нужен для фиксированных объектов

let unlock = true; //что бы не было двойных нажатий

const timeout = 800; //для адекватности скрола!как и в css-popup

if (popupLinks.length > 0) {
    for (let index = 0; index<popupLinks.length; index++) {
        const popupLink = popupLinks [index];
        popupLink.addEventListener("click", function (e){  //вешаем событие клик
            const popupName = popupLink.getAttribute('href').replace('#', '')  //для получения чистого имени popup
            const currentPopup = document.getElementById(popupName);
            popupOpen(currentPopup); //открытие попапа
            e.preventDefault() //запрещаем перезагрузку страницы
        })
    }
}
const popupCloseIcon = document.querySelectorAll('.close-popup');
if (popupCloseIcon.length > 0) {
    for (let index = 0; index < popupCloseIcon.length; index++) {
        const el = popupCloseIcon [index];
        el.addEventListener('click', function (e) {
            popupClose(el.closest('.popup'));
            e.preventDefault()
        })
    }
}
function popupOpen (currentPopup) { //передаем готовый объект
    if (currentPopup && unlock) { //проверяем есть ли и открыт ли
        const popupActive = document.querySelector('.popup.open'); //это если попап в попапе
        if (popupActive) {
            popupClose(popupActive, false);
        }
        else {
            bodyLock(); //скрытие скрола
        }
        currentPopup.classList.add('open'); //к нашему оппапу добавляем класс open css
        currentPopup.addEventListener("click", function (e) {
            if (!e.target.closest('.popup_content')) { //отсекаем все, кроме темной области
                popupClose(e.target.closest('.popup'));
            }
        });
    }
}
function popupClose (popupActive, doUnlock = true) { // передаем активнй объект, и стоит ли блокирование скрола
    if (unlock) {
        popupActive.classList.remove('open'); //убираем у активного попапа класс опен
        if (doUnlock) {
            bodyUnlock();
        }
    }
}
function bodyLock() { //скрытие скрола
    const lockPaddingValue = window.innerWidth - document.querySelector('.wrapper').offsetWidth + 'px'; //высчитываем разницу между шириной всего окна и объекта, который находится внутри

    if (lockPadding.length > 0) { //проверка на существование таких объектов
        for (let index = 0; index < lockPadding.length; index++) { //делаем то же самое с меню
            const el = lockPadding[index];
            el.style.paddingRight = lockPaddingValue;
        }
    }
    body.style.paddingRight = lockPaddingValue; //присваиваем это значение самому body
    body.classList.add('lock'); //добаваляем lock, по этому классу скрол убирается

    unlock = false; //чтобы не было повторных нажатий, избежание ошибки фиксированнного скрола
    setTimeout(function () {
        unlock = true;
    }, timeout)
}
function bodyUnlock () {
    setTimeout(function (){
        if (lockPadding.length > 0) {
            for (let index = 0; index < lockPadding.length; index++) {
                const el = lockPadding[index];
                el.style.paddingRight = '0px';
            }
        }
        body.style.paddingRight = '0px'; //убираем padding у body
        body.classList.remove('lock'); //убираем класс lock
    }, timeout); //что бы при закрытии попапа скрол появлялся через время

    unlock = false;
    setTimeout(function (){
        unlock = true;
    }, timeout)
}

/*для сортировки в шапке таблицы*/
function sortTableEmployee(n) {
    let tableEmployee, rowsEmployee, switchingEmployee, iEmployee, xEmployee, yEmployee, shouldSwitchEmployee, dirEmployee, switchCountEmployee = 0;
    tableEmployee = document.getElementById("employeeTable");
    switchingEmployee = true;
    //устанавливаем направление сортировки по умолчанию:
    dirEmployee = "asc";
    /*Создаем цикл, который будет продолжаться до тех пор, пока не было сделано переключения*/
    while (switchingEmployee) {
        //начнем с того что переключение не выполняется:
        switchingEmployee = false;
        rowsEmployee = tableEmployee.getElementsByTagName("TR");
        /*Перебираем все строки таблицы, кроме заголовка таблицы:*/
        for (iEmployee = 1; iEmployee < (rowsEmployee.length - 1); iEmployee++) {
            //начинаем с того, что переключения быть не должно:
            shouldSwitchEmployee = false;
            /*Проверяем должны ли две строки поменяться местами, в зависимости от направления, по возрастанию или убыванию:*/
            xEmployee = rowsEmployee[iEmployee].getElementsByTagName("TD")[n];
            yEmployee = rowsEmployee[iEmployee + 1].getElementsByTagName("TD")[n];
            /*если да, то поменять и разоравать цикл:*/
            if (dirEmployee == "asc") {
                if (xEmployee.innerHTML.toLowerCase() > yEmployee.innerHTML.toLowerCase()) {
                    //если да, то поментить как переключатель и разорвать цикл
                    shouldSwitchEmployee= true;
                    break;
                }
            } else if (dirEmployee == "desc") {
                if (xEmployee.innerHTML.toLowerCase() < yEmployee.innerHTML.toLowerCase()) {
                    //если да, отметить переключатель и разорвите цикл:
                    shouldSwitchEmployee = true;
                    break;
                }
            }
        }
        if (shouldSwitchEmployee) {
            /*Если переключатель отмечен, то сделать и отметить, что переключение было сделано*/
            rowsEmployee[iEmployee].parentNode.insertBefore(rowsEmployee[iEmployee + 1], rowsEmployee[iEmployee]);
            switchingEmployee = true;
            //Каждый раз, когда выполняется переключение, увеличить это значние на 1:
            switchCountEmployee ++;
        } else {
            /*Если переключение не было сделано и направление "возрастание", установить направление на "desk" и снова запустить цикл*/
            if (switchCountEmployee == 0 && dirEmployee == "asc") {
                dirEmployee = "desc";
                switchingEmployee = true;
            }
        }
    }
}
function sortTableTask(n) {
    let tableTask, rowsTask, switchingTask, iTask, xTask, yTask, shouldSwitchTask, dirTask, switchCountTask = 0;
    tableTask = document.getElementById("taskTable");
    switchingTask = true;
    dirTask = "asc";
    while (switchingTask) {
        switchingTask = false;
        rowsTask = tableTask.getElementsByTagName("TR");
        for (iTask = 1; iTask < (rowsTask.length - 1); iTask++) {
            shouldSwitchTask = false;
            xTask = rowsTask[iTask].getElementsByTagName("TD")[n];
            yTask = rowsTask[iTask + 1].getElementsByTagName("TD")[n];
            /*если да, то поменять и разоравать цикл:*/
            if (dirTask == "asc") {
                if (xTask.innerHTML.toLowerCase() > yTask.innerHTML.toLowerCase()) {
                    shouldSwitchTask= true;
                    break;
                }
            } else if (dirTask == "desc") {
                if (xTask.innerHTML.toLowerCase() < yTask.innerHTML.toLowerCase()) {
                    shouldSwitchTask = true;
                    break;
                }
            }
        }
        if (shouldSwitchTask) {
            rowsTask[iTask].parentNode.insertBefore(rowsTask[iTask + 1], rowsTask[iTask]);
            switchingTask = true;
            switchCountTask ++;
        } else {
            if (switchCountTask == 0 && dirTask == "asc") {
                dirTask = "desc";
                switchingTask = true;
            }
        }
    }
}
function sortTableCandidate(n) {
    let tableCandidate, rowsCandidate, switchingCandidate, iCandidate, xCandidate, yCandidate, shouldSwitchCandidate, dirCandidate, switchCountCandidate = 0;
    tableCandidate = document.getElementById("candidateTable");
    switchingCandidate = true;
    dirCandidate = "asc";
    while (switchingCandidate) {
        switchingCandidate = false;
        rowsCandidate = tableCandidate.getElementsByTagName("TR");
        for (iCandidate = 1; iCandidate < (rowsCandidate.length - 1); iCandidate++) {
            shouldSwitchCandidate = false;
            xCandidate = rowsCandidate[iCandidate].getElementsByTagName("TD")[n];
            yCandidate = rowsCandidate[iCandidate + 1].getElementsByTagName("TD")[n];
            /*если да, то поменять и разоравать цикл:*/
            if (dirCandidate == "asc") {
                if (xCandidate.innerHTML.toLowerCase() > yCandidate.innerHTML.toLowerCase()) {
                    shouldSwitchCandidate= true;
                    break;
                }
            } else if (dirCandidate == "desc") {
                if (xCandidate.innerHTML.toLowerCase() < yCandidate.innerHTML.toLowerCase()) {
                    shouldSwitchCandidate = true;
                    break;
                }
            }
        }
        if (shouldSwitchCandidate) {
            rowsCandidate[iCandidate].parentNode.insertBefore(rowsCandidate[iCandidate + 1], rowsCandidate[iCandidate]);
            switchingCandidate = true;
            switchCountCandidate ++;
        } else {
            if (switchCountCandidate == 0 && dirCandidate == "asc") {
                dirCandidate = "desc";
                switchingCandidate = true;
            }
        }
    }
}

/*поиск*/
function searchByNameEmployee() {
    let inputName, filterName, tableName, trName, tdName, iName;
    inputName = document.getElementById("nameInputEmployee");
    filterName = inputName.value.toUpperCase();
    tableName = document.getElementById("employeeTable");
    trName = tableName.getElementsByTagName("tr");
    for (iName = 0; iName < trName.length; iName++) {
        tdName = trName[iName].getElementsByTagName("td")[1];
        if (tdName) {
            if (tdName.innerHTML.toUpperCase().indexOf(filterName) > -1) {
                trName[iName].style.display = "";
            } else {
                trName[iName].style.display = "none";
            }
        }
    }
}
function searchByPostEmployee() {
    let inputPost, filterPost, tablePost, trPost, tdPost, iPost;
    inputPost = document.getElementById("postInputEmployee");
    filterPost = inputPost.value.toUpperCase();
    tablePost = document.getElementById("employeeTable");
    trPost = tablePost.getElementsByTagName("tr");
    for (iPost = 0; iPost < trPost.length; iPost++) {
        tdPost = trPost[iPost].getElementsByTagName("td")[3];
        if (tdPost) {
            if (tdPost.innerHTML.toUpperCase().indexOf(filterPost) > -1) {
                trPost[iPost].style.display = "";
            } else {
                trPost[iPost].style.display = "none";
            }
        }
    }
}
function searchByTagEmployee() {
    let inputTag, filterTag, tableTag, trTag, tdTag, iTag;
    inputTag = document.getElementById("tagInputEmployee");
    filterTag = inputTag.value.toUpperCase();
    tableTag = document.getElementById("employeeTable");
    trTag = tableTag.getElementsByTagName("tr");
    for (iTag = 0; iTag < trTag.length; iTag++) {
        tdTag = trTag[iTag].getElementsByTagName("td")[5];
        if (tdTag) {
            if (tdTag.innerHTML.toUpperCase().indexOf(filterTag) > -1) {
                trTag[iTag].style.display = "";
            } else {
                trTag[iTag].style.display = "none";
            }
        }
    }
}
function searchByProjectEmployee() {
    let inputProject, filterProject, tableProject, trProject, tdProject, iProject;
    inputProject = document.getElementById("projectInputEmployee");
    filterProject = inputProject.value.toUpperCase();
    tableProject = document.getElementById("employeeTable");
    trProject = tableProject.getElementsByTagName("tr");
    for (iProject = 0; iProject < trProject.length; iProject++) {
        tdProject = trProject[iProject].getElementsByTagName("td")[4];
        if (tdProject) {
            if (tdProject.innerHTML.toUpperCase().indexOf(filterProject) > -1) {
                trProject[iProject].style.display = "";
            } else {
                trProject[iProject].style.display = "none";
            }
        }
    }
}
function searchByIdEmployee() {
    let inputId, filterId, tableId, trId, tdId, iId;
    inputId = document.getElementById("idInputEmployee");
    filterId = inputId.value.toUpperCase();
    tableId = document.getElementById("employeeTable");
    trId = tableId.getElementsByTagName("tr");
    for (iId = 0; iId < trId.length; iId++) {
        tdId = trId[iId].getElementsByTagName("td")[0];
        if (tdId) {
            if (tdId.innerHTML.toUpperCase().indexOf(filterId) > -1) {
                trId[iId].style.display = "";
            } else {
                trId[iId].style.display = "none";
            }
        }
    }
}
function searchByNameCandidate() {
    let inputNameCandidate, filterNameCandidate, tableNameCandidate, trNameCandidate, tdNameCandidate, iNameCandidate;
    inputNameCandidate = document.getElementById("nameInputCandidate");
    filterNameCandidate = inputNameCandidate.value.toUpperCase();
    tableNameCandidate = document.getElementById("candidateTable");
    trNameCandidate = tableNameCandidate.getElementsByTagName("tr");
    for (iNameCandidate = 0; iNameCandidate < trNameCandidate.length; iNameCandidate++) {
        tdNameCandidate = trNameCandidate[iNameCandidate].getElementsByTagName("td")[1];
        if (tdNameCandidate) {
            if (tdNameCandidate.innerHTML.toUpperCase().indexOf(filterNameCandidate) > -1) {
                trNameCandidate[iNameCandidate].style.display = "";
            } else {
                trNameCandidate[iNameCandidate].style.display = "none";
            }
        }
    }
}
function searchByPostCandidate() {
    let inputPostCandidate, filterPostCandidate, tablePostCandidate, trPostCandidate, tdPostCandidate, iPostCandidate;
    inputPostCandidate = document.getElementById("postInputCandidate");
    filterPostCandidate = inputPostCandidate.value.toUpperCase();
    tablePostCandidate = document.getElementById("candidateTable");
    trPostCandidate = tablePostCandidate.getElementsByTagName("tr");
    for (iPostCandidate = 0; iPostCandidate < trPostCandidate.length; iPostCandidate++) {
        tdPostCandidate = trPostCandidate[iPostCandidate].getElementsByTagName("td")[3];
        if (tdPostCandidate) {
            if (tdPostCandidate.innerHTML.toUpperCase().indexOf(filterPostCandidate) > -1) {
                trPostCandidate[iPostCandidate].style.display = "";
            } else {
                trPostCandidate[iPostCandidate].style.display = "none";
            }
        }
    }
}
function searchByTagCandidate() {
    let inputTagCandidate, filterTagCandidate, tableTagCandidate, trTagCandidate, tdTagCandidate, iTagCandidate;
    inputTagCandidate = document.getElementById("tagInputCandidate");
    filterTagCandidate = inputTagCandidate.value.toUpperCase();
    tableTagCandidate = document.getElementById("candidateTable");
    trTagCandidate = tableTagCandidate.getElementsByTagName("tr");
    for (iTagCandidate = 0; iTagCandidate < trTagCandidate.length; iTagCandidate++) {
        tdTagCandidate = trTagCandidate[iTagCandidate].getElementsByTagName("td")[4];
        if (tdTagCandidate) {
            if (tdTagCandidate.innerHTML.toUpperCase().indexOf(filterTagCandidate) > -1) {
                trTagCandidate[iTagCandidate].style.display = "";
            } else {
                trTagCandidate[iTagCandidate].style.display = "none";
            }
        }
    }
}
function searchByIdCandidate() {
    let inputIdCandidate, filterIdCandidate, tableIdCandidate, trIdCandidate, tdIdCandidate, iIdCandidate;
    inputIdCandidate = document.getElementById("idInputCandidate");
    filterIdCandidate = inputIdCandidate.value.toUpperCase();
    tableIdCandidate = document.getElementById("candidateTable");
    trIdCandidate = tableIdCandidate.getElementsByTagName("tr");
    for (iIdCandidate = 0; iIdCandidate < trIdCandidate.length; iIdCandidate++) {
        tdIdCandidate = trIdCandidate[iIdCandidate].getElementsByTagName("td")[0];
        if (tdIdCandidate) {
            if (tdIdCandidate.innerHTML.toUpperCase().indexOf(filterIdCandidate) > -1) {
                trIdCandidate[iIdCandidate].style.display = "";
            } else {
                trIdCandidate[iIdCandidate].style.display = "none";
            }
        }
    }
}

/*для вкладки сбор команды*/
function makeCheckboxGroup(container) {
    const parentCheckbox = container.querySelector('input[type="checkbox"][data-role="parent"]');
    const childrenCheckboxes = container.querySelectorAll('input[type="checkbox"]:not([data-role="parent"])');

    childrenCheckboxes.forEach(chk => chk.addEventListener('click', () => {
        const checkedCheckboxes = Array.from(childrenCheckboxes).filter(chk => chk.checked);

        parentCheckbox.checked = checkedCheckboxes.length > 0;
    }));

    parentCheckbox.addEventListener('click', () => {
        childrenCheckboxes.forEach(chk => {
            chk.checked = parentCheckbox.checked;
        });
    });
}


document.querySelectorAll('.checkbox-group').forEach(makeCheckboxGroup);

function getCheckedCheckBoxes() {
    let checkboxes = document.getElementsByClassName('checkbox');
    let checkboxesChecked = []; // можно в массиве их хранить, если нужно использовать
    for (let index = 0; index < checkboxes.length; index++) {
        if (checkboxes[index].checked) {
            checkboxesChecked.push(checkboxes[index].value); // положим в выбранный массив
        }
    }
    return checkboxesChecked; // для использования в нужном месте
}
