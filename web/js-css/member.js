// 查询会员
$(document).ready(function(){
    $("#selectMember").click(function(){
        var targetUrl = $("#selectMemberForm").attr("action");
        var method = $("#selectMemberForm").attr("method")
        var data = $("#selectMemberForm").serialize();
        $.ajax({
            type:method,
            url:targetUrl,
            cache: false,
            data:data,
            dataType:'json',
            success:function(data){
                $("#membersTable  tr:not(:first)").html("");
                var len = data.length;
                alert("查询到"+len+"条信息!");
                for(var i=0;i<len;i++){
                    var member = data[i];
                    var tr = $("<tr></tr>");
                    tr.append(addAtd(member.id));
                    tr.append(addAtd(member.name));
                    tr.append(addAtd(member.discount));
                    tr.append(addAtd(member.tel));
                    tr.append(addAtd(time(member.date)));
                    tr.append(getBtntd());
                    $('#membersTable').append(tr);
                }
            },
            error:function(){
                alert("请求失败!")
            }
        })
    })
});

// 新增会员
$(document).ready(function(){
    $("#addMember").click(function(){
        var targetUrl = $("#addMemberForm").attr("action");
        var method = $("#addMemberForm").attr("method")
        var data = $("#addMemberForm").serializeArray();
        var flag = true, i;
        for (i=0; i < data.length; i++) {
            if (data[i].value.replace(/(^\s*)|(\s*$)/g, "") == '') {
                alert("会员信息字段值不能为空!");
                flag = false;
                break;
            };
        }
        if (flag) {
            data = $("#addMemberForm").serialize();
            $.ajax({
                type:method,
                url:targetUrl,
                cache: false,
                data:data,
                dataType:'text',
                success:function(data){
                    if (data == '0')
                        alert("新增会员失败!");
                    else if (data == '1')
                        alert("新增会员成功!");
                },
                error:function(){
                    alert("请求失败!")
                }
            })
        }


    })
});


// 删除一个会员
$(document).ready(function(){
    $("#membersTable").on('click', '.deleteMemberBtn', function () {
        var memberInfo = $(this).parent().siblings('td');
        var memberId = $(memberInfo[0]).text();
        var msg = "您确定要删除会员:【" + memberId + "】吗?这可能影响您的销售记录!";
        if (confirm(msg)) {
            $.ajax({
                type: 'post',
                url: '/bsms/member/delete',
                cache: false,
                data: {'memberId': memberId},  //重点必须为一个变量如：data
                dataType: 'text',
                success: function (data) {
                    if (data == '0')
                        alert("会员删除失败!");
                    else if (data == '1')
                        alert("会员删除成功!");
                    $(this).parent().parent().remove();
                },
                error: function () {
                    alert("请求失败")
                }
            })
        }
    });
});

// 更改会员信息
$(document).ready(function(){
    $("#membersTable").on('click', '.updateMemberBtn', function () {
        var memberInfo = $(this).parent().siblings('td');
        var memberId = $(memberInfo[0]).text();
        var memberName = $(memberInfo[1]).text();
        var memberDiscount = $(memberInfo[2]).text();
        var memberTel = $(memberInfo[3]).text();
        $("#nmemberId").val(memberId);
        $("#nmemberId").attr("readonly", "on");
        $("#nmemberName").val(memberName);
        $("#nmemberDiscount").val(memberDiscount);
        $("#nmemberTel").val(memberTel);
        $("#dialog-form").dialog( "open" );
    });
});

// 时间戳转指定日期格式
function time(time) {
    var date = new Date(time + 8 * 3600 * 1000); // 增加8小时
    return date.toJSON().substr(0, 19).replace('T', ' ');
}

// 得到一个列节点
function addAtd(info) {
    var td = $("<td></td>");
    td.text(info);
    return td;
}

// 得到按钮节点
function getBtntd() {
    var td = $("<td></td>");
    var btn = $('<input class="updateMemberBtn" type="button" value="编辑">');
    td.append(btn);
    btn = $('<input class="deleteMemberBtn" type="button" value="删除">');
    td.append(btn);
    return td;
}

//样式
$(document).ready(function(){
    $("#selectMember").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $("#addMember").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $(".updateMemberBtn").hover(function(){
        $(this).css("color","white");
    },function(){
        $(this).css("color","#000");
    });

    $(".deleteMemberBtn").hover(function(){
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

