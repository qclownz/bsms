// 查询入库记录
$(document).ready(function(){
    $("#selectEntryRecord").click(function(){
        var targetUrl = $("#selectEntryRecordForm").attr("action");
        var method = $("#selectEntryRecordForm").attr("method");
        var data = $("#selectEntryRecordForm").serialize();
        $.ajax({
            type:method,
            url:targetUrl,
            cache: false,
            data:data,
            dataType:'json',
            success:function(data){
                $("#entryRecordTable  tr:not(:first)").html("");
                var len = data.length;
                alert("查询到"+len+"条信息!");
                for(var i=0;i<len;i++){
                    var entryRecord = data[i];
                    var tr = $("<tr></tr>");
                    tr.append(addAtd(entryRecord.id));
                    tr.append(addAtd(time(entryRecord.date)));
                    tr.append(addAtd(entryRecord.bookId));
                    tr.append(addAtd(entryRecord.amount));
                    tr.append(getBtntd());
                    $('#entryRecordTable').append(tr);
                }
            },
            error:function(){
                alert("请求失败!")
            }
        })
    })
});

// 删除条入库记录
$(document).ready(function(){
    $("#entryRecordTable").on('click', '.deleteEntryRecordBtn', function () {
        var entryRecordInfo = $(this).parent().siblings('td');
        var entryRecordId = $(entryRecordInfo[0]).text();
        var msg = "您确定要删除订单:【" +entryRecordId + "】吗?这将严重影响您的书籍记录!";
        if (confirm(msg)) {
            $.ajax({
                type: 'post',
                url: '/bsms//entryrecord/delete',
                cache: false,
                data: {'entryRecordId':entryRecordId},
                dataType: 'text',
                success: function (data) {
                    if (data == '0')
                        alert("订单删除失败!");
                    else if (data == '1')
                        alert("订单删除成功!");
                    $(this).parent().parent().remove();
                },
                error: function () {
                    alert("请求失败")
                }
            })
        }
    });
});

// 得到按钮节点
function getBtntd() {
    var td = $("<td></td>");
    var btn = $('<input class="deleteEntryRecordBtn" type="button" value="删除">');
    td.append(btn);
    return td;
}

function addAtd(info) {
    var td = $("<td></td>");
    td.text(info);
    return td;
}

function time(time) {
    var date = new Date(time + 8 * 3600 * 1000); // 增加8小时
    return date.toJSON().substr(0, 19).replace('T', ' ');
}

$(document).ready(function(){
    $("#selectEntryRecord").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $(".deleteEntryRecordBtn").hover(function(){
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