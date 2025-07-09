from flask import Flask, request, jsonify

app = Flask(__name__)

@app.route('/analyze', methods=['POST'])
def analyze():
    data = request.get_json()
    text = data.get('text', '').lower()

    summary_parts = []
    warnings = []

    # Basic summary instructions
    if "amoxicillin" in text:
        summary_parts.append("Take Amoxicillin twice daily after food.")
    if "ibuprofen" in text:
        summary_parts.append("Use Ibuprofen only if pain increases.")
    if "metformin" in text:
        summary_parts.append("Take Metformin with meals to control blood sugar.")
    if "aspirin" in text:
        summary_parts.append("Take Aspirin daily for heart protection.")
    if "warfarin" in text:
        summary_parts.append("Take Warfarin as directed for anticoagulation.")

    # New drug interaction rules
    if "ibuprofen" in text and "aspirin" in text:
        warnings.append("Ibuprofen + Aspirin may increase bleeding risk.")
    if "warfarin" in text and "ibuprofen" in text:
        warnings.append("Warfarin + Ibuprofen may cause serious bleeding.")
    if "warfarin" in text and "aspirin" in text:
        warnings.append("Warfarin + Aspirin may increase risk of bleeding.")
    if "metformin" in text and ("steroids" in text or "prednisone" in text):
        warnings.append("Metformin with steroids may elevate blood sugar levels.")

    # Default fallback summary
    if not summary_parts:
        summary_parts.append("Take medications exactly as prescribed.")

    summary = " ".join(summary_parts)

    return jsonify({
        "summary": summary,
        "warnings": warnings
    })

if __name__ == '__main__':
    app.run(port=5000)
