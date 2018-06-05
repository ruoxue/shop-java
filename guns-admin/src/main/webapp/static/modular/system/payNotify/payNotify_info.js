/**
 * 初始化详情对话框
 */
var PayNotifyInfoDlg = {
    payNotifyInfoData : {}
};

/**
 * 清除数据
 */
PayNotifyInfoDlg.clearData = function() {
    this.payNotifyInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PayNotifyInfoDlg.set = function(key, val) {
    this.payNotifyInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PayNotifyInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PayNotifyInfoDlg.close = function() {
    parent.layer.close(window.parent.PayNotify.layerIndex);
}

/**
 * 收集数据
 */
PayNotifyInfoDlg.collectData = function() {
    this
    .set('id')
    .set('userID')
    .set('title')
    .set('content')
    .set('cTime')
    .set('toUser')
    .set('type');
}

/**
 * 提交添加
 */
PayNotifyInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/payNotify/add", function(data){
        Feng.success("添加成功!");
        window.parent.PayNotify.table.refresh();
        PayNotifyInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.payNotifyInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PayNotifyInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/payNotify/update", function(data){
        Feng.success("修改成功!");
        window.parent.PayNotify.table.refresh();
        PayNotifyInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.payNotifyInfoData);
    ajax.start();
}

$(function() {

});
