$(document).ready(function () {

    //save shop
    $("#save").on('click', function () {
        let url = '/api/shop';
        createRequest("POST", "#save", url);
    });

    //update shop
    $("#update").on('click', function () {
        let url = '/api/shop/' + shopObject.id;
        createRequest("PUT", "#update", url);
    });

    //get shop
    $(document).on('click', 'table tbody tr', function () {
        window.location = $(this).attr('href');
    });

    //get shops by page
    $("#paginationButton").on('click', function () {
        let paginationButton = $("#paginationButton");
        let page = parseInt($(this).attr('value'));
        let url = '/api/shop/page/' + page;
        $.ajax({
            type: "GET",
            url: url,
            beforeSend: function () {
            },
            success: function (shop) {
                drawTable(shop, "#shopTable");
                page = page + 1;
                paginationButton.attr('value', page);
            },
            error: function (e) {
                paginationButton.hide();
            }
        })
    });
});

function createRequest(method, button, url) {
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

function drawTable(shops, tableName) {
    let table = $(tableName).find("tbody");
    let index = table.find('tr').length;
    for (let i = 0; i < shops.length; i++) {
        table.append(
            '<tr href="shop/update/' + shops[i].id + '">' +
            '<td>' + ++index + '</td>' +
            '<td>' + shops[i].name + '</td>' +
            '<td>' + shops[i].priority + '</td>' +
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
    if (shop.haveCookRoom) {
        $("#haveCookRoom").prop('checked', true);
    }
    $("#type").val(shop.type);
    $("#metro").val(shop.metro);
    $("#priority").val(shop.priority);
    $("#comment").val(shop.comment);
}