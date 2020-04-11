// 查询销售记录
$(document).ready(function(){
    $("#selectSalesRecord").click(function(){
        var targetUrl = $("#selectSalesRecordForm").attr("action");
        var method = $("#selectSalesRecordForm").attr("method");
        var data = $("#selectSalesRecordForm").serialize();
        $.ajax({
            type:method,
            url:targetUrl,
            cache: false,
            data:data,
            dataType:'json',
            success:function(data){
                $("#salesRecordTable  tr:not(:first)").html("");
                var len = data.length;
                alert("查询到"+len+"条信息!");
                for(var i=0;i<len;i++){
                    var salesRecord = data[i];
                    var tr = $("<tr></tr>");
                    tr.append(addAtd(salesRecord.id));
                    tr.append(addAtd(time(salesRecord.date)));
                    tr.append(addAtd(salesRecord.bookId));
                    tr.append(addAtd(salesRecord.amount));
                    tr.append(addAtd(salesRecord.memberId));
                    tr.append(addAtd(salesRecord.price.toFixed(2)));
                    tr.append(addAtd(salesRecord.value.toFixed(2)));
                    tr.append(getBtntd());
                    $('#salesRecordTable').append(tr);
                }
            },
            error:function(){
                alert("请求失败!")
            }
        })
    })
});

// 删除某条销售记录
$(document).ready(function(){
    $("#salesRecordTable").on('click', '.deleteSalesRecordBtn', function () {
        var salesRecordInfo = $(this).parent().siblings('td');
        var salesRecordId = $(salesRecordInfo[0]).text();
        var msg = "您确定要删除订单:【" + salesRecordId + "】吗?这将使系统无法统计到该订单的信息, 影响您的销售记录!";
        if (confirm(msg)) {
            $.ajax({
                type: 'post',
                url: '/bsms/salesrecord/delete',
                cache: false,
                data: {'salesRecordId':salesRecordId},
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
    var btn = $('<input class="deleteSalesRecordBtn" type="button" value="删除">');
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
    $("#selectSalesRecord").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $(".deleteSalesRecordBtn").hover(function(){
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