
export function validateBook(book) {
    const errors = [];

    // Kiểm tra tên sách
    if (!book.title || !book.title.trim()) {
        errors.push("Tên sách không được để trống");
    }

    // Kiểm tra tác giả
    if (!book.author || !book.author.trim()) {
        errors.push("Tác giả không được để trống");
    }

    // Kiểm tra ISBN
    if (!book.isbn || !book.isbn.trim()) {
        errors.push("ISBN không được để trống");
    }

    return {
        isValid: errors.length === 0,
        errors: errors
    };
}
