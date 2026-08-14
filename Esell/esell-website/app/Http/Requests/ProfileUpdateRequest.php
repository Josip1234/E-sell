<?php

namespace App\Http\Requests;

use App\Models\User;
use Illuminate\Contracts\Validation\ValidationRule;
use Illuminate\Foundation\Http\FormRequest;
use Illuminate\Validation\Rule;

class ProfileUpdateRequest extends FormRequest
{
    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'email' => [
                'required',
                'string',
                'lowercase',
                'email',
                'max:255',
                Rule::unique(User::class)->ignore($this->user()->id),
            ],
            'username'=>['required','string','max:255','min:1'],
            'firstName'=>['required','string','max:255','min:1'],
            'lastName'=>['required','string','max:255','min:1'],
            'profilePicture'=>['required','file','mimes:jpg,png,webp,gif,svg,jpeg,tiff,arw,cr2,raw,rw2'],
        ];
    }
}
