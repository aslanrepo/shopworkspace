$(document).ready(function() {

    //save shop
    $("#save").on('click', function () {
        createRequest("POST", "#save");
    });

    //update shop
    $("#update").on('click', function () {
        createRequest("PUT", "#update");
    });

    //get shop
    $(document).on('click', 'table tbody tr', function () {
        window.location = $(this).attr('href');
    });

    //get shops by page
    $("#paginationButton").on('click', function () {
        let page = parseInt($(this).attr('value'));
        let url = '/api/shop/page/' + page;
        $.ajax({
            type: "GET",
            url: url,
            beforeSend: function () {
            },
            success: function (shop) {
                drawShopTable(shop);
                page = page + 1;
                $("#paginationButton").attr('value', page);

            },
            error: function (e) {
                $("#paginationButton").hide();
            }
        })
    });
});

function createRequest(method, button) {
    let url = '/api/shop';
    let shop = getShopObjectJSON();
    $.ajax({
        type: method,
        url: url,
        contentType: "application/json; charset=utf-8",
        data: shop,
        beforeSend: function () {
            $(button).text("Подождите...");
        },
        success: function () {
            window.location = document.referrer;
        },
        error: function (e) {
            $(button).text("Ошибка");
        }
    });
}

function drawShopTable(shops) {
    let table = $("#shopTable").find("tbody");
    for (let i = 0; i < shops.length; i++) {
        table.append(
            '<tr href="shop/update/'+ shops[i].id +'">' +
            '<td>'+ shops[i].name +'</td>' +
            '<td>'+ shops[i].priority +'</td>' +
            '</tr>'
        )
    }
}

function getShopObjectJSON() {
    let creationDate = ifPropertyExists(shopObject, 'creationDate');
    let shop = {
        id: ifPropertyExists(shopObject, 'id'),
        name: getValue($("#name").val()),
        address: getValue($("#address").val()),
        phoneNumber: getValue($("#phoneNumber").val()),
        partner: getValue($("#partner").val()),
        haveCookRoom: $("#haveCookRoom").is(":checked"),
        type: getValue($("#type").val()),
        metro: getValue($("#metro").val()),
        priority: getValue($("#priority").val()),
        comment: getValue($("#comment").val()),
        creationDate: creationDate === null ? new Date() : creationDate,
    };
    return JSON.stringify(shop);
}

function getValue(value) {
    return value === "" ? null : value;
}
function ifPropertyExists(obj, prop) {
    return obj.hasOwnProperty(prop) ? obj[prop] : null;
}

function setUpdateMode(shop) {

    $("#save").attr('id', "update");

    $("#name").val(shop.name);
    $("#address").val(shop.address);
    $("#phoneNumber").val(shop.phoneNumber);
    $("#partner").val(shop.partner);
    if(shop.haveCookRoom) {
        $("#haveCookRoom").prop('checked', true);
    }
    $("#type").val(shop.type);
    $("#metro").val(shop.metro);
    $("#priority").val(shop.priority);
    $("#comment").val(shop.comment);
}