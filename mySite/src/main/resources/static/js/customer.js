/**
 * 
 * @Author Xuefeng Chen 
 */
    
/**
 * Show all customers in the table
 * @param  {} data customers data
 */
var showCustomer = function(data){
    let line = "";
    for (var i = 0; i < data.length; i++) {
        line += "<tr><td>" + data[i].id + "</td><td>"
                + data[i].firstName + "</td><td>" + data[i].lastName
                + "</td><td>" + data[i].email + "</td>";
        line += "<td>	<button type='button' onclick='getCustomer(this.getAttribute(\"data-id\"))' class='btn btn-primary edit-button' data-toggle='modal' data-target='#editModal' data-id='"
                + data[i].id + "'>edit</button>";
        line += "<td><button type='button' onclick='deleteCustomer(this.getAttribute(\"data-id\"));' class='delete-button btn btn-danger' data-id='"
                + data[i].id + "'>delete</button></td>";
        line += "<tr>";
    }
    $("#customer-list").html(line);
}

//Retrieve customers when page ready
$("document").ready(function(){
    getCustomers();
})

/**
 * Retrieve a customer by its id
 * Add customer info to modal
 * @param  {} id customer id
 */
var getCustomer = function(id) {//get a single customer
    $.ajax({
        url : './list/customer/' + id,
        type : 'Get',
        data : '',
        dataType : 'json',
        crossDomain : true,
    })
    .done(function(data){
        $("#modal-firstname").val(data.firstName);
        $("#modal-lastname").val(data.lastName);
        $("#modal-email").val(data.email);
        $("#update-button").attr("data-id",data.id);
    });
}


/**
 * Get all customers
 */
var getCustomers = function() {
    $.ajax({
        url : './list/customer',
        type : 'Get',
        data : '',
        dataType : 'json',
        crossDomain : true,
    })
    .done(function(data){
        showCustomer(data)
    });
}


/**
 * Add customer according to form submission
 */
var addCustomer = function() {
    let customerData = {};
    $("#add-customer-form").serializeArray().map(function(x) {
        customerData[x.name] = x.value;
    });
    $.ajax({
        url : './list/customer',
        type : 'Post',
        data : customerData,
        dataType : 'json',
        crossDomain : true,
    })
    .done(function(data){
        showCustomer(data)
    });
}


/**
 * Update customer by customer id
 * @param  {} id customer id
 */
var updateCustomer = function(id){
    let customerData = {};
    $("#edit-form").serializeArray().map(function(x) {
        customerData[x.name] = x.value;
    });
    $.ajax({
        url : './list/customer/'+id,
        type : 'Put',
        data : customerData,
        dataType : 'json',
        crossDomain : true,
    })
    .done(function(data){
        showCustomer(data)
    });
}


/**
 * Delete customer by customer id
 * @param  {} id customer id
 */
var deleteCustomer = function(id) {
    $.ajax({
        url : './list/customer/' + id,
        type : 'Delete',
        data : '',
        dataType : 'json',
        crossDomain : true,
    })
    .done(function(data){
        showCustomer(data)
    });
}