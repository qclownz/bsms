// 查询图书
$(document).ready(function(){
    $("#selectBook").click(function(){
        var targetUrl = $("#selectBookForm").attr("action");
        var method = $("#selectBookForm").attr("method");
        var data = $("#selectBookForm").serialize();
        $.ajax({
            type:method,
            url:targetUrl,
            cache: false,
            data:data,
            dataType:'json',
            success:function(data){
                $("#booksTable  tr:not(:first)").html("");
                var len = data.length;
                alert("查询到"+len+"条信息!");
                for(var i=0;i<len;i++){
                    var book = data[i];
                    var tr = $("<tr></tr>");
                    tr.append(addAtd(book.id));
                    tr.append(addAtd(book.name));
                    tr.append(addAtd(book.author));
                    tr.append(addAtd(book.publish));
                    tr.append(addAtd(book.price.toFixed(2)));
                    tr.append(addAtd(book.amount));
                    tr.append(getBtntd());
                    $('#booksTable').append(tr);
                }
            },
            error:function(){
                alert("请求失败!")
            }
        })
    })
});

// 更改图书的数量
$(document).ready(function(){
    $("#addBookAmount").click(function(){
        var targetUrl = $("#addBookAmountForm").attr("action");
        var method = $("#addBookAmountForm").attr("method")
        var data = $("#addBookAmountForm").serialize();
        $.ajax({
            type:method,
            url:targetUrl,
            cache: false,
            data:data,
            dataType:'text',
            success:function(data){
                if (data == '0')
                    alert("书籍入库失败!");
                else if (data == '1')
                    alert("书籍入库成功!");
            },
            error:function(){
                alert("请求失败!")
            }
        })
    })
});

// 新增一本书
$(document).ready(function(){
    $("#addBook").click(function(){
        var targetUrl = $("#addBookForm").attr("action");
        var method = $("#addBookForm").attr("method")
        var data = $("#addBookForm").serializeArray();
        var flag = true, i;
        for (i=0; i < data.length; i++) {
            if (data[i].value.replace(/(^\s*)|(\s*$)/g, "") == '') {
                alert("书籍信息字段值不能为空!");
                flag = false;
                break;
            };
        }
        if (flag) {
            data = $("#addBookForm").serialize();
            $.ajax({
                type:method,
                url:targetUrl,
                cache: false,
                data:data,
                dataType:'text',
                success:function(data){
                    if (data == '0')
                        alert("新增图书失败!");
                    else if (data == '1')
                        alert("新增图书成功!");
                },
                error:function(){
                    alert("请求失败!")
                }
            });
        }

    })
});

// 删除一本书
$(document).ready(function(){
    $("#booksTable").on('click', '.deleteBookBtn', function () {
        var bookInfo = $(this).parent().siblings('td');
        var bookId = $(bookInfo[0]).text();
        var msg = "您确定要删除书籍:【" + bookId + "】吗?这将严重影响您的书籍记录!";
        if (confirm(msg)) {
            $.ajax({
                type: 'post',
                url: '/bsms/book/delete',
                cache: false,
                data: {'bookId':bookId},  //重点必须为一个变量如：data
                dataType: 'text',
                success: function (data) {
                    if (data == '0')
                        alert("书籍删除失败!书籍的数量不为0!");
                    else if (data == '1')
                        alert("书籍删除成功!");
                        $(this).parent().parent().remove();
                },
                error: function () {
                    alert("请求失败")
                }
            })
        }
    });
});

// 更改一本书
$(document).ready(function(){
    $("#booksTable").on('click', '.updateBookBtn', function () {
        var bookInfo = $(this).parent().siblings('td');
        var bookId = $(bookInfo[0]).text();
        var bookName = $(bookInfo[1]).text();
        var bookAuthor = $(bookInfo[2]).text();
        var bookPublish = $(bookInfo[3]).text();
        var bookPrice = $(bookInfo[4]).text();
        $("#nbookId").val(bookId);
        $("#nbookId").attr("readonly", "on");
        $("#nbookName").val(bookName);
        $("#nbookAuthor").val(bookAuthor);
        $("#nbookPublish").val(bookPublish);
        $("#nbookPrice").val(bookPrice);
        $("#dialog-form").dialog( "open" );
    });
});

// 得到一个列节点
function addAtd(info) {
    var td = $("<td></td>");
    td.text(info);
    return td;
}

// 得到按钮节点
function getBtntd() {
    var td = $("<td></td>");
    var btn = $('<input class="updateBookBtn" type="button" value="编辑">');
    td.append(btn);
    btn = $('<input class="deleteBookBtn" type="button" value="删除">');
    td.append(btn);
    return td;
}

$(document).ready(function(){
    $("#selectBook").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $("#addBookAmount").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $("#addBook").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $(".updateBookBtn").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $(".deleteBookBtn").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

});

$(document).ready(function(){
    $("tr").hover(function(){
        $(this).css("background-color","pink");
    },function(){
        $(this).css("background-color","transparent");
    });

});



