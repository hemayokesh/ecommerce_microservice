import React from 'react';
import ProductList from '../components/ProductList';
import AddProduct from '../components/AddProduct';

const Home = () => (
  <div>
    <h1>Product Catalog</h1>
    <ProductList />
    <hr />
    <AddProduct />
  </div>
);

export default Home;
