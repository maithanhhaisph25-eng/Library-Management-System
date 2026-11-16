
import { test } from "node:test";
import assert from "node:assert/strict";
import { validateBook } from "../js/validation.js";

// TC01: Kiểm tra khi nhập đầy đủ thông tin
test("TC01 - Du lieu sach hop le", () => {

    // Arrange: Chuẩn bị dữ liệu
    const book = {
        title: "Lap trinh Java",
        author: "Nguyen Van A",
        isbn: "9780134685991"
    };

    // Act: Thực hiện kiểm tra
    const result = validateBook(book);

    // Assert: Kiểm tra kết quả
    assert.equal(result.isValid, true);
    assert.equal(result.errors.length, 0);
});

// TC02: Kiểm tra khi bỏ trống tên sách
test("TC02 - Ten sach khong duoc de trong", () => {

    // Arrange
    const book = {
        title: "",
        author: "Nguyen Van A",
        isbn: "9780134685991"
    };

    // Act
    const result = validateBook(book);

    // Assert
    assert.equal(result.isValid, false);
    assert.ok(result.errors.includes(
        "Tên sách không được để trống"
    ));
});

// TC03: Kiểm tra khi bỏ trống tác giả và ISBN
test("TC03 - Tac gia va ISBN khong duoc de trong", () => {

    // Arrange
    const book = {
        title: "Lap trinh Java",
        author: "",
        isbn: ""
    };

    // Act
    const result = validateBook(book);

    // Assert
    assert.equal(result.isValid, false);
    assert.equal(result.errors.length, 2);
});
