<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Heavy Discount</title>
    <style>
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        body {
            background-image: url('https://moneysavingcentral.co.uk/images/clothes-sale-dates.jpg');
            background-repeat: no-repeat;
            background-size: cover;
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            padding: 20px;
            background-color: #333;
            color: #fff;
            margin: 0;
        }

        .product-box {
            display: flex;
            align-items: center;
            background-color: #f9f9f9;
            padding: 10px;
            margin-bottom: 10px;
            transition: all 0.3s ease-in-out;
            max-width: 800px; /* Updated width value */
        }

        .product-image-container {
            width: 30%;
            position: relative;
        }

        .product-image {
            width: 100%;
            height: auto;
            border-radius: 50%;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.2);
        }

        .product-details {
            flex: 1;
            padding: 0 20px;
        }

        .product-action {
            margin-left: auto;
        }

        .product-action a {
            text-decoration: none;
            color: #333;
            font-weight: bold;
            padding: 8px 12px;
            background-color: #f9f9f9;
            border: 1px solid #333;
            border-radius: 4px;
            transition: all 0.3s ease-in-out;
        }

        .product-action a:hover {
            background-color: #333;
            color: #fff;
        }

        .prev-image-btn,
        .next-image-btn {
            position: absolute;
            bottom: -20px;
            transform: translateY(-50%);
            background-color: transparent;
            border: none;
            color: #333;
            font-size: 24px;
            cursor: pointer;
        }

        .prev-image-btn {
            left: -20px;
        }

        .next-image-btn {
            right: -20px;
        }

        .prev-image-btn:hover,
        .next-image-btn:hover {
            color: #f00;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Heavy Discount</h1>
        
        <div class="search-container">
            <form action="<s:url action='searchProducts'/>" method="get">
                <input type="text" name="query" placeholder="Search products...">
                <input type="submit" value="Search">
            </form>
        </div>

        <div class="product-box">
            <div class="product-image-container">
                <img src="./image/jeans1.jpg" alt="Jeans" class="product-image" />
                <button class="prev-image-btn">-</button>
                <button class="next-image-btn">></button>
            </div>
            <div class="product-details">
                <div class="product-id">1</div>
                <div class="product-name">
                    <h2>Jeans</h2>
                </div>
                <div class="product-price"> Price:Rs 900</div>
                <div class="product-discount">Discount: 50%</div>
                 <div class="product-tax">Tax include:Rs 25</div>
                  <div class="product-dilivery">Dilivery Charges:Rs 25</div>
                                 <div class="product-price">
                    <strong>Total Price(including all charges): Rs 500</strong>
                </div>
                 
            </div>
            <div class="product-action">
                <a href="<s:url action='buy'><s:param name='id'>1</s:param><s:param name='productName'>Jeans</s:param><s:param name='price'>500</s:param></s:url>">Buy</a>
            </div>
        </div>

        <div class="product-box">
            <div class="product-image-container">
                <img src="./image/OIP.jpeg" alt="Shirt" class="product-image" />
                <button class="prev-image-btn">-</button>
                <button class="next-image-btn">></button>
            </div>
            <div class="product-details">
                <div class="product-id">2</div>
                <h2>Shirt</h2>
                 <div class="product-price"> Price:Rs1300</div>
                <div class="product-discount">Discount: 50%</div>
                 <div class="product-tax">Tax include:Rs25</div>
                  <div class="product-dilivery">Dilivery Charges:Rs25</div>
         <div class="product-price">
                    <strong>Total Price(including all charges): Rs 700</strong>
                </div>         
            </div>
            <div class="product-action">
                <a href="<s:url action='buy'><s:param name='id'>2</s:param><s:param name='productName'>Shirt</s:param><s:param name='price'>700</s:param></s:url>">Buy</a>
            </div>
        </div>

        <div class="product-box">
            <div class="product-image-container">
                <img src="./image/s1.jpeg" alt="Sneaker" class="product-image" />
                <button class="prev-image-btn">-</button>
                <button class="next-image-btn">></button>
            </div>
            <div class="product-details">
                <div class="product-id">3</div>
                <h2>Sneaker</h2>
                 <div class="product-price"> Price:Rs1900</div>
                <div class="product-discount">Discount: 50%</div>
                 <div class="product-tax">Tax include:Rs25</div>
                  <div class="product-dilivery">Dilivery Charges:Rs25</div>
                           <div class="product-price">
                    <strong>Total Price(including all charges): Rs 1000</strong>
                </div>
            </div>
            <div class="product-action">
                <a href="<s:url action='buy'><s:param name='id'>3</s:param><s:param name='productName'>sneaker</s:param><s:param name='price'>1000</s:param></s:url>">Buy</a>
            </div>
        </div>
    </div>

    <script>
        document.addEventListener("DOMContentLoaded", function() {
            const prevBtns = document.querySelectorAll(".prev-image-btn");
            const nextBtns = document.querySelectorAll(".next-image-btn");
            const productImages = document.querySelectorAll(".product-image");
            const prevImageUrls = [
                "./image/jeans1.jpg",
                "./image/OIP.jpeg",
                "./image/s1.jpeg"
            ];
            const nextImageUrls = [
                "./image/jeans2.jpeg",
                "./image/whiteshirt(1).jpeg",
                "./image/s2.jpeg"
            ];

            prevBtns.forEach((btn, index) => {
                btn.addEventListener("click", function() {
                    productImages[index].src = prevImageUrls[index];
                });
            });

            nextBtns.forEach((btn, index) => {
                btn.addEventListener("click", function() {
                    productImages[index].src = nextImageUrls[index];
                });
            });
        });
    </script>
</body>
</html>
