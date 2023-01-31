
export function elementGenerator(value,tag,id,className){
    return "<"+tag+" class='"+className+" "+ id +"'>" + value + "</" + tag + ">";
}

export function inputGenerator(value,type,id,className,colName){
return "<input type='"+type+"' class='"+className+" "+ id +" " +colName + "' value='"+value+"'>";
}

export function buttonsGenerator(id){
return "<button id='edit' data-id='"+id+"' type='button' class='btn btn-primary edit-btn'><i class='uil uil-edit'></i></i>Edytuj</button>&nbsp<button type='button' id='save' data-id='"+id+"' class='btn btn-primary save-btn'><i class='uil uil-trash-alt'></i></i>Zapisz</button> &nbsp <button type='button' id='delete' data-id='"+id+"' class='btn btn-primary'><i class='uil uil-trash-alt'></i></i>Usuń</button>";
}

export function buttonsGeneratorEditAsLink(id,name){
    return "<a href='"+name+"?id="+id+"'><button type='button' class='btn btn-primary edit-btn'><i class='uil uil-edit'></i></i>Edytuj</button></a>&nbsp<button type='button' id='save' data-id='"+id+"' class='btn btn-primary save-btn'><i class='uil uil-trash-alt'></i></i>Zapisz</button> &nbsp <button type='button' id='delete' data-id='"+id+"' class='btn btn-primary'><i class='uil uil-trash-alt'></i></i>Usuń</button>";
}
    
export function buttonsGeneratorNextStep(id,name){
    return "<a href='"+name+"?id="+id+"'><button type='button' class='btn btn-primary edit-btn'>Wybierz</button></a>";
}

export function searchParametr(name){
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    return urlParams.get(name);
}