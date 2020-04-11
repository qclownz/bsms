// 出售图书
$(document).ready(function(){
    $("#saleBookBtn").click(function(){
        var targetUrl = $("#saleBookForm").attr("action");
        var method = $("#saleBookForm").attr("method");
        var data = $("#saleBookForm").serialize();
        $.ajax({
            type:method,
            url:targetUrl,
            cache: false,
            data:data,
            dataType:'json',
            success:function(data){
                if (data == 0) {
                    var bookId = $("#bookId").val();
                    alert("书籍【" + bookId +"】不存在或者书籍数量不够!")
                } else if (data == -1) {
                    var memberId = $("#memberId").val();
                    alert("会员【" + memberId + "】不存在!");
                } else {
                    if (confirm("需支付金额【" + data['value'].toFixed(2) + '】')) {
                        $.ajax({
                            type: method,
                            url: '/bsms/sales/add',
                            data: data,
                            dataType: 'json',
                            success: function (data) {
                                    if (data == 1) {
                                        alert("销售成功!");
                                    } else {
                                        alert("销售失败!");
                                    }
                                },
                            error: function () {
                                    alert("请求失败!");
                                }
                        })
                    }
                }

            },
            error:function(){
                alert("请求失败!")
            }
        })
    })
});

$(document).ready(function(){
    $("a").hover(function(){
        $(this).css("color","#ff7171");
    },function(){
        $(this).css("color","#000")
    });
});

$(document).ready(function(){
    $("#saleBookBtn").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });
});