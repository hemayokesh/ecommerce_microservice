import React, { useState } from 'react';
import { addProduct } from '../api';

const AddProduct = () => {
  const [form, setForm] = useState({ name: '', price: '', inventory: '' });

  const handleChange = (e) => {
    setForm({...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    addProduct(form)
      .then(() => alert('Product added successfully'))
      .catch(err => console.error(err));
  };

  return (
    <div>
      <h2>Add New Product</h2>
      <form onSubmit={handleSubmit}>
        <input name="name" placeholder="Product Name" onChange={handleChange} required />
        <input name="price" type="number" placeholder="Price" onChange={handleChange} required />
        <input name="inventory" type="number" placeholder="Inventory" onChange={handleChange} required />
        <button type="submit">Add Product</button>
      </form>
    </div>
  );
};

export default AddProduct;
