function onClick(value) {
    if (document.getElementsByClassName('sourcePosition').length) {
        return selectDestinationPiece(value);
    } else {
        sourcePosition(value);
    }
}

function sourcePosition(value) {
    document.getElementById(value).classList.add('sourcePosition');
}


function resetSourcePosition() {
    if (document.getElementsByClassName('sourcePosition')[0].innerHTML) {
        document.getElementsByClassName('sourcePosition')[0].innerHTML = "";
    }
    document.getElementsByClassName('sourcePosition')[0].classList.remove('sourcePosition');
}

function movePiece(value) {
    document.getElementById(value).innerHTML =
        document.getElementsByClassName('sourcePosition')[0].innerHTML;
    console.log(document.getElementsByClassName('sourcePosition')[0].id);

    resetSourcePosition();
}

function selectDestinationPiece(value) {
    $.ajax({
        type: "get",
        url: "/chess",
        data: {
            source: document.getElementsByClassName("sourcePosition")[0].id,
            target: document.getElementById(value).id
        },
        dataType: "text",
        success: function (data, status, XHR) {
            console.log(status);
            console.log(XHR.responseText);
            if (data) {
                alert(data);
                return;
            }
            movePiece(value);
        },
        error: function (jqXHR) {
            resetSourcePosition();
            console.log('error');
            alert(jqXHR.responseText);
        }
    });
}