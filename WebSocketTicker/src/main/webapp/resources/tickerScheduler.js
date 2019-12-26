    //Create stomp client over sockJS protocol
    var socket = new SockJS("/WebSocketTicker/ws");
    var stompClient = Stomp.over(socket);

    // Callback function to be called when stomp client is connected to server
    var connectCallback = function() {
      stompClient.subscribe('/topic/price', renderPrice);
    }; 

    // Render price data from server into HTML, registered as callback
    // when subscribing to price topic
    function renderPrice(frame) {
      var prices = JSON.parse(frame.body);
      $('#priceDisplay').empty();
     for(var i in prices) {
       var price = prices[i];
        $('#priceDisplay').append( price.code + ':$' + price.price.toFixed(2) + '   ' );

      }
    }

    // Callback function to be called when stomp client could not connect to server
    var errorCallback = function(error) {
      alert(error.headers.message);
    };

    // Connect to server via websocket 
    // with function to display stock in banner[connectCallback]
    // and function to handle errors [errorCallback]
    stompClient.connect("guest", "guest", connectCallback, errorCallback);
    
    // Register handler for add button
    // calls server to save stock
    $(document).ready(function() {
      $('.add').click(function(e){
        e.preventDefault();
        var code = $('.new .code').val();
        var price = Number($('.new .price').val());
        var sendData = JSON.stringify({ 'code': code, 'price': price });
        stompClient.send("/TickerApp/addStock", {}, sendData);
        return false;
      });
    });
    
    // Register handler for remove all button
    // calls server to delete all stocks
    $(document).ready(function() {
      $('.remove-all').click(function(e) {
        e.preventDefault();
        stompClient.send("/TickerApp/removeAllStocks");
        return false;
      });
    });
    
    


