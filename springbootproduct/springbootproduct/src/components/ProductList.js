import React, { useEffect, useState } from 'react';
import { getAllProducts } from '../api';

const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    getAllProducts()
      .then(response => setProducts(response.data))
      .catch(error => console.error('Error fetching products', error));
  }, []);

  return (
    <div>
      <h2>Available Products</h2>
      <ul>
        {products.map(product => (
          <li key={product.id}>
            {product.name} - ₹{product.price} - {product.inventory > 0 ? "In Stock" : "Out of Stock"}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;
