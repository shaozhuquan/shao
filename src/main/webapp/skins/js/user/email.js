/**
 * Created by shaozhuquan on 2018/10/9.
 */

var context = "/" + window.location.pathname.split("/")[1];

$(document).ready(function(){



    //form表单提交
    function save() {
        var url = context + '/service/autoModel/tableMapping/saveLinkMapping';
        $("#addLinkMapping").ajaxSubmit({
            url :url,
            type : 'POST',
            success : function(data) {
                if(data.status){
                    $.dialog({
                        type:'alert',
                        content:"保存成功",
                        ok:function(){
                            //刷新父节点
                            window.parent.refreshParentNode(datasourceId);
                            window.location.href=context+"/jsp/autoModel/tableList.jsp?datasourceId="+datasourceId;
                        }
                    })
                }else{
                    $.dialog({
                        type:'alert',
                        content:"保存失败"
                    })
                }
            },
            error : function(errmsg) {
                console.log(errmsg);
            }
        });
    }
})
